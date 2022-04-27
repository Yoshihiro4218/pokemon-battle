<template>
  <div class="loading-modal-div d-flex justify-content-center align-items-center m-8">
    <b-card class="loading-modal-card" :title="title" border-variant="dark">
      <b-card-text>
        LOADING...
        <div class="progress">
          <div class="progress-bar progress-bar-striped progress-bar-animated"
                role="progressbar" aria-valuenow="100" style="width: 100%"></div>
        </div>
      </b-card-text>
    </b-card>
  </div>
</template>

<script>
export default {
  name: 'LoadingModal',
  props: {
    title: {
      type: String,
      required: true,
    },
  },
  created() {
    let bodyEl = document.getElementsByTagName('body')[0];
    bodyEl.setAttribute('style', 'overflow-y: hidden;');
  },
  mounted() {
    let scrollY = window.scrollY;
    let modalEl = document.getElementsByClassName('loading-modal-div')[0];
    modalEl.setAttribute('style', `top: ${scrollY}px;`);
  },
  destroyed() {
    let bodyEl = document.getElementsByTagName('body')[0];
    bodyEl.removeAttribute('style');
  }
}
</script>

<style>
  .loading-modal-div {
    width: 100%;
    height: 100%;
    z-index: 100;
    position: absolute;
    left: 0;
    background-color: rgba(201, 201, 201, 0.50);
  }
  .loading-modal-card {
    width: 20rem;
    height: 10rem;
  }
</style>
