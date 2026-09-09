package TUFR.WithSingleton;

public class JudgeanalyticsEagerLoadingMain {

    public static void main(String[] args) {
        JudgeAnalyticsEagerLoadingImpl judgeAnalyticsEagerLoadingImpl1 = JudgeAnalyticsEagerLoadingImpl.getInstance();
        JudgeAnalyticsEagerLoadingImpl judgeAnalyticsEagerLoadingImpl2 = JudgeAnalyticsEagerLoadingImpl.getInstance();
        System.out.println(judgeAnalyticsEagerLoadingImpl1);
        System.out.println(judgeAnalyticsEagerLoadingImpl2);
    }
}
