import Vue from 'vue'
import VueRouter from 'vue-router'
import ShowCats from '@/views/ShowCats.vue'
import AddCat from '@/views/AddCat'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: ShowCats
  },
  {
    path: '/add-cat',
    component: AddCat
  },
  {
    path: '/show-cats',
    component: ShowCats
  }
]

const router = new VueRouter({
  routes
})

export default router
