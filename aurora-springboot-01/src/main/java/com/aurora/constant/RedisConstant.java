package com.aurora.constant;

public interface RedisConstant {

    String MAIN_URL = "xzy-blog:";

    long CODE_EXPIRE_TIME = 5 * 60;

    String USER_CODE_KEY = MAIN_URL+"code:";

    String BLOG_VIEWS_COUNT = MAIN_URL+"blog_views_count";

    String ARTICLE_VIEWS_COUNT = MAIN_URL+"article_views_count";

    String WEBSITE_CONFIG = MAIN_URL+"website_config";

    String USER_AREA = MAIN_URL+"user_area";

    String VISITOR_AREA = MAIN_URL+"visitor_area";

    String ABOUT = MAIN_URL+"about";

    String UNIQUE_VISITOR = MAIN_URL+"unique_visitor";

    String LOGIN_USER = MAIN_URL+"login_user";

    String ARTICLE_ACCESS = MAIN_URL+"article_access:";

}
