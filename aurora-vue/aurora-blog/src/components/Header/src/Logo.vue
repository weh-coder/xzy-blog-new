<template>
  <div class="flex items-start self-stretch relative" @click="handleClick">
    <div class="flex flex-col relative py-4 z-10 text-white font-medium ob-drop-shadow cursor-pointer" @click="">
      <span class="flex text-3xl" v-if="websiteConfig.name">
        <img class="logo-image" :src="websiteConfig.logo" alt="site-logo" :title="`${websiteConfig.name}--${websiteConfig.englishName}`"/>
      </span>
      <span v-else class="flex text-3xl animation-text">LOADING</span>
    </div>
  </div>
</template>

<script lang="ts">
import { useAppStore } from '@/stores/app'
import { computed } from '@vue/reactivity'
import { defineComponent } from 'vue'
import { useRouter } from 'vue-router'
import { useCommonStore } from '@/stores/common'
import { useNavigatorStore } from '@/stores/navigator'

export default defineComponent({
  name: 'Logo',
  setup() {
    const appStore = useAppStore()
    const commonStore = useCommonStore()
    const navigatorStore = useNavigatorStore()
    const router = useRouter()
    const handleClick = () => {
      router.push({ path: '/' })
      if (commonStore.isMobile && navigatorStore.openMenu === true) {
        navigatorStore.toggleMobileMenu()
      }
    }
    return {
      websiteConfig: computed(() => {
        return appStore.websiteConfig
      }),
      handleClick
    }
  }
})
</script>

<style lang="scss" scoped>
.logo-image {
  height: 60px;
  width: 60px;
  max-width: 200px;
  top: -5px;
  left: -25px;
  @apply absolute mr-2 rounded-full;
}
</style>
