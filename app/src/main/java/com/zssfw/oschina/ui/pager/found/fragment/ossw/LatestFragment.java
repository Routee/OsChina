package com.zssfw.oschina.ui.pager.found.fragment.ossw;

import com.zssfw.oschina.util.Uris;

/**
 * Created by Routee on 2017/2/24.
 */

public class LatestFragment extends BasicOsscFragment {

    @Override
    public void setUrl() {
        headUrl = Uris.FOUND_OSSW_LATEST1;
        footUrl = Uris.FOUND_OSSW_LATEST2;
    }
}
