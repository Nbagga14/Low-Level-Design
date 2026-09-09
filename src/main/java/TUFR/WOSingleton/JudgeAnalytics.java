package TUFR.WOSingleton;

public class JudgeAnalytics {

    private int run=0;
    private int submit=0;

    public void countRun() {
        run++;
    }

    public void countSubmit(){
        submit++;
    }

    public int getCountRun() {
        return run;
    }

    public static void main(String[] args) {
        JudgeAnalytics judgeAnalytics1 = new JudgeAnalytics();
        judgeAnalytics1.countRun();

        JudgeAnalytics judgeAnalytics2 = new JudgeAnalytics();
        judgeAnalytics2.countRun();


        System.out.println(judgeAnalytics1.getCountRun()); // returns 1 whereas total runs are 2 because gets instantiated for each object
        System.out.println(judgeAnalytics2.getCountRun());// returns 1 whereas total runs are 2 because gets instantiated for each object
    }
}
