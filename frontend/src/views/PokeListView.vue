<template>
<div class="pokeImgsDiv">
            <div class="pokeImgDiv" v-for="imgUrl of imgUrls" v-bind:key="imgUrls">
                <img alt="pokemon" class="pokeImg" v-bind:src="imgUrl">
            </div>
</div>
</template>

<script>
    export default {
        name: "PokeListView",
        data() {
            return {
                items: [],
                imgUrls: [],
            }
        },
        components: {},
        computed: {},
        watch: {
            items() {
            }
        },
        mounted() {
            for(let i=1; i<=151 ; i++ ) {
                this.imgUrls.push(`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${i}.png`);
            }
        },
        methods: {
        }
    }
</script>

<style scoped>
    .pokeImgsDiv {
        text-align: center;
        position: relative;
        display: block;
        box-sizing: border-box;
        margin-right: auto;
        margin-left: auto;
    }

    .pokeImgDiv {
        display: inline-block;
    }

    .pokeImg {
    }

    .pokeImg:hover {
        color: red;
        cursor: pointer;
        outline: 1px solid gray;
    }

</style>