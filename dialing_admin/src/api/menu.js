/*
 * @Descripttion:
 * @version:
 * @Date: 2021-04-20 11:06:21
 * @LastEditors: lulinwei
 * @LastEditTime: 2021-07-26 13:37:30
 * @Author: huzhushan@126.com
 * @HomePage: https://huzhushan.gitee.io/vue3-element-admin
 * @Github: https://github.com/huzhushan/vue3-element-admin
 * @Donate: https://huzhushan.gitee.io/vue3-element-admin/donate/
 */
import request from '@/utils/request'

const base_api = '/admin/system/index'

// 获取菜单
export const GetMenus = params => {
  return request({
    url: `${base_api}/menus`,
    method: 'get',
    params,
  })
}
