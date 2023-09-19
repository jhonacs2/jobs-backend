package constants;

public final class ConstantsTableNames {
    public interface CompanyTable {
        String COMPANY_TABLE_NAME = "companies";
        String NAME = "name";
        String LOCATION = "location";
        String LOGO = "logo";
    }

    public interface JobTable {
        String JOB_TABLE_NAME = "jobs";
        String DESCRIPTION = "description";
        String TYPE = "type";
        String REQUIREMENTS = "requirements";
        String CREATED_AT = "created_at";
    }

    public interface SocialMediaTable {
        String SOCIAL_TABLE_NAME = "social_medias";
        String NAME = "name";
        String URL = "url";
    }
}
