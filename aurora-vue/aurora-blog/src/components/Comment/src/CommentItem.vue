<template>
  <div class="mt-5 max-w-full">
    <div class="flex space-x-3 xl:space-x-5">
      <Avatar :url="comment.avatar" />
      <div class="max-w-full-calc space-y-5">
        <div class="bg-white text-primary p-4 rounded-md relative shadow-md reply" style="width: fit-content">
          <span class="text-xs">{{ comment.nickname }}<span v-if="comment.userId==1" class="author-style text-xs">【{{ t('settings.author') }}】</span></span>
          <p class="commentContent" v-html="comment.commentContent.replaceAll('\n', '<br>')" />
          <div class="flex justify-between mt-2 text-xs text-gray-400 space-x-3 md:space-x-16">
            <div>
              <span>
                {{ new Date(time).getFullYear()}}
                {{ t(`settings.months[${new Date(time).getMonth()}]`) }}
                {{ new Date(time).getDate() }},
                {{ formatTime(time) }}
              </span>
              <span @click="clickOnReply" class="cursor-pointer reply-button">
                <svg class="svg-icon message-svg message-svg" aria-hidden="true" style="width: 1.5em;height:1.5em;display:inline-block; stroke: rgba(255, 255, 255, var(--tw-text-opacity));"
                 data-v-c8a70580="" data-v-7b23b1e6=""><use href="#icon-message" data-v-c8a70580=""></use></svg>
                {{ t('settings.reply') }}
              </span>
            </div>
          </div>
        </div>
        <CommentReplyForm
          v-show="show"
          :replyUserId="comment.userId"
          :initialContent="replyContent"
          @changeShow="changeShow" />
        <transition-group name="fade">
          <CommentReplyItem
            v-for="reply in comment.replyDTOs"
            :key="reply.id"
            :reply="reply"
            :commentUserId="comment.userId" />
        </transition-group>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref, toRefs, provide } from 'vue'
import Avatar from '@/components/Avatar.vue'
import CommentReplyItem from './CommentReplyItem.vue'
import CommentReplyForm from './CommentReplyForm.vue'
import formatTime from '@/utils/format_time'
import { useI18n } from 'vue-i18n'



export default defineComponent({
  components: {
    Avatar,
    CommentReplyItem,
    CommentReplyForm
  },
  props: ['comment', 'index'],
  setup(props) {
    const { t } = useI18n()
    const comment: any = props.comment
    provide('parentId', comment.id)
    provide('index', props.index)

    const reactiveData = reactive({
      replyContent: '' as any,
      time: props.comment.createTime,
      show: false as any
    })
    const changeShow = () => {
      reactiveData.show = false
    }
    const clickOnReply = () => {
      reactiveData.replyContent = '@'+props.comment.nickname
      reactiveData.show = true
    }
    return {
      ...toRefs(reactiveData),
      clickOnReply,
      changeShow,
      formatTime,
      t
    }
  }
})
</script>
<style lang="scss" scoped>
.reply::before {
  content: '';
  position: absolute;
  width: 0;
  height: 0;
  border-right: 8px solid var(--background-primary);
  border-top: 6px solid transparent;
  border-bottom: 6px solid transparent;
  left: -8px;
  top: 14px;
}
.reply {
  background: var(--background-primary);
}
.reply-button {
  color: var(--text-reply);
  margin-left: 1rem;
}
.author-style{
  color: var(--text-author-style);
}
.commentContent {
  line-height: 26px;
  white-space: pre-line;
  word-wrap: break-word;
  word-break: break-all;
}
</style>
