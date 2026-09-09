package Singleton.WithSingleton;
public class JudgeAnalyicsLazyLoadingMain {

    public static void main(String[] args) {

        JudgeAnalyticsLazyLoadingImpl judgeAnalyticsLazyLoading1 = JudgeAnalyticsLazyLoadingImpl.getInstance();
        JudgeAnalyticsLazyLoadingImpl judgeAnalyticsLazyLoading2 = JudgeAnalyticsLazyLoadingImpl.getInstance();
        System.out.println(judgeAnalyticsLazyLoading1); //same as judgeAnalyticsLazyLoading2
        System.out.println(judgeAnalyticsLazyLoading2);

    }
}
