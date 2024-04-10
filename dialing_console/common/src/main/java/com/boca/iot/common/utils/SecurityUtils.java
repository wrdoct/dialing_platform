//package com.boca.iot.utils;
//
//import org.apache.shiro.subject.Subject;
//
///**
// * @author lulinwei
// */
//public class SecurityUtils {
//
//    public static final String REQUEST_AUTH_HEADER = "Authorization";
//    public static final String APP_AUTH_HEADER = "token";
//    public static final String TENANT_ID_COLUMN = "developer_id";
//    public static final String TENANT = "tenant";
//    public static final String ADMIN_TENANT_ID = "-1";
//
//    public static Long getCurrentUserId() {
//        Subject currentUser = org.apache.shiro.SecurityUtils.getSubject();
//        return JwtUtils.getUserId(currentUser.getPrincipal().toString());
//    }
//
//    public static String getCurrentUserAccount() {
//        Subject currentUser = org.apache.shiro.SecurityUtils.getSubject();
//        return JwtUtils.getUserAccount(currentUser.getPrincipal().toString());
//    }
//
//    public static Subject getSubject() {
//        return org.apache.shiro.SecurityUtils.getSubject();
//    }
//
//    public static boolean hasRole(String roleName) {
//        return getSubject() != null && roleName != null && roleName.length() > 0 && getSubject().hasRole(roleName);
//    }
//
//    public static boolean lacksRole(String roleName) {
//        return !hasRole(roleName);
//    }
//
//    public static boolean hasAnyRoles(String roleNames) {
//        boolean hasAnyRole = false;
//        Subject subject = getSubject();
//        if (subject != null && roleNames != null && roleNames.length() > 0) {
//            String[] var3 = roleNames.split(",");
//            int var4 = var3.length;
//
//            for(int var5 = 0; var5 < var4; ++var5) {
//                String role = var3[var5];
//                if (subject.hasRole(role.trim())) {
//                    hasAnyRole = true;
//                    break;
//                }
//            }
//        }
//
//        return hasAnyRole;
//    }
//
//    public static boolean hasAllRoles(String roleNames) {
//        boolean hasAllRole = true;
//        Subject subject = getSubject();
//        if (subject != null && roleNames != null && roleNames.length() > 0) {
//            String[] var3 = roleNames.split(",");
//            int var4 = var3.length;
//
//            for(int var5 = 0; var5 < var4; ++var5) {
//                String role = var3[var5];
//                if (!subject.hasRole(role.trim())) {
//                    hasAllRole = false;
//                    break;
//                }
//            }
//        }
//
//        return hasAllRole;
//    }
//
//    public static boolean hasPermission(String permission) {
//        return getSubject() != null && permission != null && permission.length() > 0 && getSubject().isPermitted(permission);
//    }
//
//    public static boolean lacksPermission(String permission) {
//        return !hasPermission(permission);
//    }
//
//    public static String principal() {
//        if (getSubject() != null) {
//            Object principal = getSubject().getPrincipal();
//            return principal.toString();
//        } else {
//            return "";
//        }
//    }
//}
