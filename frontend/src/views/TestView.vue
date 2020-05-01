<template>
    <div class="test">
        <div id="cart" style="display: none;"></div>
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQYvUFoWaWMbHG9--4QFgqrZJs68lJNE-0sNyLfhKtbdRHQlW7L"><br>
        <p id="test-price">{{price | moneyDelemiter}}円</p>
        <p id="for-test">カイリュー逆鱗発動！</p>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: 'TestView',
        data() {
            return {
                items: [],
                price: 123456,
            }
        },
        components: {},
        computed: {},
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