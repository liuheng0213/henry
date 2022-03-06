package basic.knowledge.stephen.algorithm.test;

public class Design {
    public AuthContext authContext;
    public String designContent;
    public String designId;

    public Design(AuthContext authContext, String designContent, String designId) {
        this.authContext = authContext;
        this.designContent = designContent;
        this.designId = designId;
    }

    public AuthContext getAuthContext() {
        return authContext;
    }

    public void setAuthContext(AuthContext authContext) {
        this.authContext = authContext;
    }

    public String getDesignContent() {
        return designContent;
    }

    public void setDesignContent(String designContent) {
        this.designContent = designContent;
    }

    public String getDesignId() {
        return designId;
    }

    public void setDesignId(String designId) {
        this.designId = designId;
    }



}
