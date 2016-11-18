/*
 * Copyright(c) 2007-2011 by Yingzhi Tech
 * All Rights Reserved
 * 
 * Created at 2011-04-23 14:23:05
 */

package com.yzhtech.address.util;

import java.net.URL;

/**
 *
 * @author chenjianan
 */
public class ResourceUtil {
    public static URL readIcon(String fileName){
        return ResourceUtil.class.getResource("/com/yzhtech/address/view/" + fileName);
    }
    
}
