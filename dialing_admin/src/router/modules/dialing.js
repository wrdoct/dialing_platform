/*
 * @Author lulinwei
 */

const Layout = () => import('@/layout/index.vue')
const dialingApp = () => import('@/views/dialing/dialingApp.vue')

export default [
  {
    path: '/dialing',
    component: Layout,
    name: 'dialing',
    meta: {
      title: '拨测应用管理',
    },
    icon: 'Goods', // Operation/User
    children: [
      {
        path: '/dialingApp',
        name: 'dialingApp',
        component: dialingApp,
        meta: {
          title: '拨测应用管理',
        },
        hidden: false,
      },
    ],
  },
]
