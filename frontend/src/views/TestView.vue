<template>
    <div class="test">
        [テスト] CartのViewです。
        <router-link to="/">Go to Top</router-link>
        <div id="cart" style="display: none;"></div>
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQYvUFoWaWMbHG9--4QFgqrZJs68lJNE-0sNyLfhKtbdRHQlW7L">

    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        data() {
            return {
                items: [],
            }
        },
        components: {
        },
        computed: {
        },
        watch: {
            items() {
            }
        },
        mounted() {
        },
        methods: {
            showCommodityDetail() {
            },
        }
    }
</script>

<style scoped>


</style>