package com.example.consult;

import java.io.Serializable;

public class tablets implements Serializable
{
    public String tabletname;
    public String tabletCount;

    public tablets(String tabletname)
    {
        this.tabletname = tabletname;
    }

    public tablets(String tabletname, String tabletCount)
    {
        this.tabletname = tabletname;
        this.tabletCount = tabletCount;
    }

    public String getTabletname()
    {
        return tabletname;
    }

    public void setTabletname(String tabletname) {
        this.tabletname = tabletname;
    }

    public String getTabletCount() {
        return tabletCount;
    }

    public void setTabletCount(String tabletCount) {
        this.tabletCount = tabletCount;
    }
}
