/*
 * @Descripttion:
 * @version:
 * @Date: 2021-04-20 11:06:21
 * @LastEditors: lulinwei
 * @LastEditTime: 2021-04-21 09:36:55
 * @Author: huzhushan@126.com
 * @HomePage: https://huzhushan.gitee.io/vue3-element-admin
 * @Github: https://github.com/huzhushan/vue3-element-admin
 * @Donate: https://huzhushan.gitee.io/vue3-element-admin/donate/
 */
import request from '@/utils/request'

const base_api = '/admin/system/index'

// 登录接口
export const Login = data => {
  return request({
    url: `${base_api}/login`,
    method: 'post',
    data,
  })
}

// 获取登录用户信息
export const GetUserinfo = () => {
  return request({
    url: `${base_api}/getUserInfo`,
    method: 'get',
  })
}

// 获取验证码
export const GetValidateCode = () => {
  return request({
    url: `${base_api}/generateValidateCode`,
    method: 'get',
  })
}

// 退出功能
export const Logout = () => {
  return request({
    url: `${base_api}/logout`,
    method: 'get',
  })
}
