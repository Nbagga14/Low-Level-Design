package Singleton.WithSingleton;

public class JudgeAnalyticsEagerLoadingImpl {

   public static final JudgeAnalyticsEagerLoadingImpl JUDGE_ANALYTICS = new JudgeAnalyticsEagerLoadingImpl(); // Eager Loading

   private JudgeAnalyticsEagerLoadingImpl(){

   }

   public static JudgeAnalyticsEagerLoadingImpl getInstance()
   {
       return JUDGE_ANALYTICS;
   }
}



