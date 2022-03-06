package basic.knowledge.stephen.algorithm.test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DesignServiceImpl implements DesignService {
    public Map<String, HashMap<String, Design>> storeMap;

    public DesignServiceImpl() {
        this.storeMap = new HashMap<>();
    }

    @Override
    public String createDesign(AuthContext ctx, String designContent) {
        String designId = UUID.randomUUID().toString();
        Design design = new Design(ctx, designContent, designId);
        HashMap<String, Design> subMap = null;

        if (this.storeMap.get(ctx.userId) == null) {
            subMap = new HashMap<>();
        } else {
            subMap = this.storeMap.get(ctx.userId);
        }
        subMap.put(designId, design);

        storeMap.put(ctx.userId, subMap);
        return design.getDesignId();
    }

    @Override
    public String getDesign(AuthContext ctx, String designId) {
        Map<String, Design> stringDesignMap = storeMap.get(ctx.userId);

        if (stringDesignMap != null && !stringDesignMap.isEmpty()) {
            Design design = stringDesignMap.get(designId);
            if (design == null) {
                return "";
            }
            return design.getDesignContent();
        }
        return "";
    }
}
