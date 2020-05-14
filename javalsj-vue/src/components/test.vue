<template>
<div v-bind:class="erroClass"></div>
</template>

<script>
export default {
  data() {
    return{
      erroClass: 'error'
      // activeClass: 'active'

    };

  }
}
</script>
