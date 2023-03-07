import org.junit.Assert;
import org.junit.Test;

public class MyHomeworkTests {

    /*
    В случае отказа от посещения мероприятия по причинам, не связанным с отменой/переносом мероприятия, посетитель имеет право при возврате билета:
    1) более 10 дней - получить обратно полную стоимость билетов;
    2) от 6 до 10 дней включительно - получить только 50% стоимости билетов;
    3) от 3 до 6 дней включительно - получить 30% стоимости билетов;
    4) 72 часа и менее до начала концерта - стоимость билетов не возвращается.
     */
    private int getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled) {
        if (wasConcertCancelled || wasConcertRescheduled) return 100;
        if (hoursBeforeConcert > 240) return 100;
        if (hoursBeforeConcert > 144 && hoursBeforeConcert <= 240) return 50;
        if (hoursBeforeConcert > 72 && hoursBeforeConcert <= 144) return 30;
        return 0;
    }

    @Test
    public void testCancelled() {
        int actualResult = getRefundTicketPricePercent(1, true, false);
        Assert.assertEquals(100, actualResult);
    }

    @Test
    public void testRescheduled() {
        int actualResult = getRefundTicketPricePercent(1, false, true);
        Assert.assertEquals(100, actualResult);
    }

    @Test
    public void testMoreThan240Hours() {
        int actualResult = getRefundTicketPricePercent(241, false, false);
        Assert.assertEquals(100, actualResult);
    }

    @Test
    public void test240Hours() {
        int actualResult = getRefundTicketPricePercent(240, false, false);
        Assert.assertEquals(50, actualResult);
    }

    @Test
    public void testMoreThan144Hours() {
        int actualResult = getRefundTicketPricePercent(145, false, false);
        Assert.assertEquals(50, actualResult);
    }

    @Test
    public void test144Hours() {
        int actualResult = getRefundTicketPricePercent(144, false, false);
        Assert.assertEquals(30, actualResult);
    }

    @Test
    public void testMoreThan72Hours() {
        int actualResult = getRefundTicketPricePercent(73, false, false);
        Assert.assertEquals(30, actualResult);
    }

    @Test
    public void test72HoursOrLess() {
        int actualResult = getRefundTicketPricePercent(72, false, false);
        Assert.assertEquals(0, actualResult);
    }


    /*
    Всего ученик может заработать максимум 100 баллов, минимум 0.
    Его оценка за экзамен может принимать следующие значения: 2, 3, 4 или 5.

    Если ученик получил за экзамен:
    - от 0 баллов (включительно) до 35 (включительно), его оценка равна 2;
    - от 35 баллов (не включительно) до 56 (включительно), его оценка равна 3;
    - от 56 баллов (не включительно) до 71 (включительно), его оценка равна 4;
    - от 72 баллов (включительно) до 100 баллов (включительно), его оценка равна 5.
     */
    private String getMarkResult(Integer mark) {
        if (mark >= 0 && mark <= 35) return "2";
        if (mark >= 36 && mark <= 56) return "3";
        if (mark >= 57 && mark <= 71) return "4";
        if (mark >= 72 && mark <= 100) return "5";
        return "no mark result";
    }

    @Test
    public void testGradeTwoLowerBound() {
        var actualResult = getMarkResult(0);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void testGradeTwoHigherBound() {
        var actualResult = getMarkResult(35);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void testGradeThreeLowerBound() {
        var actualResult = getMarkResult(36);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void testGradeThreeHigherBound() {
        var actualResult = getMarkResult(56);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void testGradeFourLowerBound() {
        var actualResult = getMarkResult(57);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void testGradeFourHigherBound() {
        var actualResult = getMarkResult(71);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void testGradeFiveLowerBound() {
        var actualResult = getMarkResult(72);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void testGradeFiveHigherBound() {
        var actualResult = getMarkResult(100);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void testNoMarkLowerBound() {
        var actualResult = getMarkResult(-1);
        Assert.assertEquals("no mark result", actualResult);
    }

    @Test
    public void testNoMarkHigherBound() {
        var actualResult = getMarkResult(101);
        Assert.assertEquals("no mark result", actualResult);
    }



    private String getIMTResult(Float heightCm, Float weightKg)
    {
        double value = weightKg / Math.pow((heightCm / 100), 2);
        double scale = Math.pow(10, 2);
        double userIndex = Math.ceil(value * scale) / scale;
        String userResult = null;

        if (heightCm <= 0.0f || heightCm > 350.0f){
            userResult = "указан некорректный рост";
            return userResult;
        }
        if (weightKg <= 0.0f || weightKg > 1000.0f) {
            userResult = "указан некорректный вес";
            return userResult;
        } else if (userIndex > 0&&userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        } else if (userIndex > 16 && userIndex < 19) {
            userResult = "недостаточной массе тела";
        } else if (userIndex >= 19 && userIndex < 25) {
            userResult = "нормальной массе тела";
        } else if (userIndex >= 25) {
            userResult = "избыточной массе тела";
        }
        return userResult;
    }

    @Test
    public void testNormalWeight() {
        var actualResult = getIMTResult(180f, 75f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void testNormalWeightLowerBound() {
        var actualResult = getIMTResult(198.7f, 75f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void testNormalWeightHigherBound() {
        var actualResult = getIMTResult(173.25f, 75f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void testOverWeight() {
        var actualResult = getIMTResult(170f, 75f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void testOverWeightLowerBound() {
        var actualResult = getIMTResult(173.2f, 75f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void testUnderWeight() {
        var actualResult = getIMTResult(210f, 75f);
        Assert.assertEquals("недостаточной массе тела", actualResult);
    }

    @Test
    public void testUnderWeightLowerBound() {
        var actualResult = getIMTResult(216.5f, 75f);
        Assert.assertEquals("недостаточной массе тела", actualResult);
    }

    @Test
    public void testUnderWeightHigherBound() {
        var actualResult = getIMTResult(198.75f, 75f);
        Assert.assertEquals("недостаточной массе тела", actualResult);
    }

    @Test
    public void testDeficitOfWeight() {
        var actualResult = getIMTResult(300f, 75f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    @Test
    public void testDeficitOfWeightLowerBound() {
        var actualResult = getIMTResult(350f, 0.01f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    @Test
    public void testDeficitOfWeightHigherBound() {
        var actualResult = getIMTResult(216.55f, 75f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    @Test
    public void testIncorrectHeightLowerBound() {
        var actualResult = getIMTResult(0f, 65f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    public void testIncorrectHeightHigherBound() {
        var actualResult = getIMTResult(350.01f, 65f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    public void testIncorrectWeightLowerBound() {
        var actualResult = getIMTResult(180f, 0f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    public void testIncorrectWeightHigherBound() {
        var actualResult = getIMTResult(180f, 1000.01f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

}
