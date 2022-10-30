package in.co.sanchay.common;

public class SanchaySpringServerEndPoints {

    public static String SANCHAY_CONFIG_FILENAME = "sanchay-client-config.txt";

    public static String HOME = "/home";
    public static String AUTH_BASE = "/auth";
    public static String LOGIN = "/login";
    public static String TOKEN_REFRESH = "/token/refresh";
    public static String GET_CURRENT_USER = "/current-user";
    public static String GET_USER = "/user"; // From username
    public static String DOES_USER_EXIST = "/doesUserExist"; // From username
    public static String DOES_EMAIL_EXIST = "/doesEmailExist"; // From username
    public static String GET_USERS = "/users";
    public static String GET_ROLES = "/roles";
    public static String GET_LANGUAGES = "/languages";
    public static String GET_ORGANISATIONS = "/organisations";
    public static String GET_ANNOTATION_LEVELS = "/annotation-levels";
    public static String GET_USER_ROLES = "/user/roles";
    public static String GET_USER_LANGUAGES = "/user/languages";
    public static String GET_USER_ORGANISATIONS = "/user/organisations";
    public static String GET_USER_ANNOTATION_LEVELS = "/user/annotation-levels";
    public static String GET_ROLE_USERS = "/role/users";
    public static String GET_LANGUAGE_USERS = "/language/users";
    public static String GET_ORGANISATION_USERS = "/organisation/users";
    public static String GET_ANNOTATION_LEVELS_USERS = "/annotation-levels/users";
    public static String GET_LANGUAGE_ORGANISATIONS = "/language/organisations";
    public static String GET_LANGUAGE_ANNOTATION_LEVELS = "/language/annotation-levels";
    public static String GET_ORGANISATION_LANGUAGES = "/organisation/languages";
    public static String GET_ORGANISATION_ANNOTATION_LEVELS = "/organisation/annotation-levels";
    public static String GET_ANNOTATION_LEVEL_ORGANISATIONS = "/annotation-level/organisations";
    public static String GET_ANNOTATION_LEVEL_LANGUAGES = "/annotation-level/languages";

    public static String SAVE_USER = "/users/save";
    public static String SAVE_ROLE = "/roles/save";
    public static String SAVE_LANGUAGE = "/languages/save";
    public static String SAVE_ORGANISATION = "/organisations/save";
    public static String SAVE_ANNOTATION_LEVEL = "/annotation-levels/save";

    public static String GET_ANNOTATION_MANAGEMENT_INFO = "/annotation-management-info";
    public static String SAVE_ANNOTATION_MANAGEMENT_INFO = "/annotation-management-info/save";

    public static String DELETE_USER = "/users/delete";
    public static String DELETE_ROLE = "/roles/delete";
    public static String DELETE_LANGUAGE = "/languages/delete";
    public static String DELETE_ORGANISATION = "/organisations/delete";
    public static String DELETE_ANNOTATION_LEVEL = "/annotation-levels/delete";

    public static String FILE_SERVER_BASE = "/files";

    public static String GET_BASE_ANNOTATION_DIRECTORY = "/base";
    public static String LIST_FILES_IN_DIRECTORY = "/list-files";
    public static String UPLOAD_FILE = "/upload";
    public static String DOWNLOAD_FILE = "/download";
    public static String DELETE_FILE = "/delete";
    public static String IS_DIRECTORY = "/is-directory";

    public SanchaySpringServerEndPoints()
    {

    }

}
