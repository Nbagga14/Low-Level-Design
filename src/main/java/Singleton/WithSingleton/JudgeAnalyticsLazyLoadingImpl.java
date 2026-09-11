package Singleton.WithSingleton;

// synchroniaztion way to for lazy loading
/*public class JudgeAnalyticsLazyLoadingImpl {

    private static volatile JudgeAnalyticsLazyLoadingImpl judgeAnalyticsLazyLoading;
    private JudgeAnalyticsLazyLoadingImpl()
    {

    }
// synchronized keyword is added for thread safety since lazy loading not thread safe
    public static synchronized JudgeAnalyticsLazyLoadingImpl getInstance()
    {
        if(judgeAnalyticsLazyLoading==null){
            judgeAnalyticsLazyLoading = new JudgeAnalyticsLazyLoadingImpl();
        }
        return judgeAnalyticsLazyLoading;
    }

}*/

//Better version


public class JudgeAnalyticsLazyLoadingImpl {

    private static JudgeAnalyticsLazyLoadingImpl judgeAnalyticsLazyLoading;
    private static class Holder
    {
       private static final JudgeAnalyticsLazyLoadingImpl JudgeAnalyticsLazyLoadingImpl = new JudgeAnalyticsLazyLoadingImpl();
    }

    public static JudgeAnalyticsLazyLoadingImpl getInstance() {
        return Holder.JudgeAnalyticsLazyLoadingImpl;
    }
}







