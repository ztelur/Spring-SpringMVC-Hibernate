package com.nju.ee.po;

import java.util.List;
import java.util.Map;

/**
 * Created by homer on 16-10-31.
 */
public class TeamPo {
    private Map<String, List<PersonPo>> team;

    public Map<String, List<PersonPo>> getTeam() {
        return team;
    }

    public void setTeam(Map<String, List<PersonPo>> team) {
        this.team = team;
    }
}
