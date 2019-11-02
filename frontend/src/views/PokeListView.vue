<template>
    <div class="pokeImgsDiv">

        <div class="card text-white bg-danger trainersDiv pleaseCreate" v-if="pokeMaxFlg===true">
            ポケモンが6匹選択されいます。選び直す場合は一度クリアしてください。
        </div>

        <div class="pokeImgDiv" v-for="(imgUrl, idx) of imgUrls" :key="idx">
            <img alt="pokemon" class="pokeImg" v-bind:src="imgUrl"
                 v-on:click="pushPoke(idx)">
        </div>

        <div class="card text-white bg-danger trainersDiv pleaseCreate" v-if="pokeMaxFlg===true">
            ポケモンが6匹選択されいます。選び直す場合は一度クリアしてください。
        </div>

        <div class="buttonDiv">
            <div class="card bg-success text-white text-center p-3 titleDisplay allPoke"
                 v-on:click="returnPreviousPage()">
                <blockquote class="blockquote mb-0">
                    <p>決定</p>
                </blockquote>
            </div>

            <div class="card bg-info text-white text-center p-3 titleDisplay allPoke"
                 v-on:click="clearPokes()">
                <blockquote class="blockquote mb-0">
                    <p>クリア</p>
                </blockquote>
            </div>

            <div class="card bg-danger text-white text-center p-3 titleDisplay allPoke"
                 v-on:click="returnPreviousPage()">
                <blockquote class="blockquote mb-0">
                    <p>キャンセル</p>
                </blockquote>
            </div>
        </div>

    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "PokeListView",
        data() {
            return {
                items: [],
                imgUrls: [],
                selectedPokes: [],
                pokeMaxFlg: false,
            }
        },
        components: {},
        computed: {},
        watch: {
            selectedPokes() {
            }
        },
        mounted() {
            for (let i = 1; i <= 151; i++) {
                this.imgUrls.push(`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${i}.png`);
            }
        },
        methods: {
            returnPreviousPage(id) {
                this.$router.push(`/myPokeList?id=${id}`);
            },
            pushPoke(idx) {
                console.log("selected poke is...");
                console.log(idx + 1);

                if (this.selectedPokes.length < 6) {
                    this.selectedPokes.push(idx + 1);
                    console.log("pokes=" + this.selectedPokes);
                } else {
                    this.pokeMaxFlg = true;
                    alert("ポケモンが6匹選択されいます。選び直す場合は一度クリアしてください。");
                    console.log("Max!!");
                }
            },
            clearPokes() {
                this.selectedPokes.length = 0;
                this.pokeMaxFlg = false;
                console.log("selected pokes were cleared!");
            }
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


    .titleDisplay {
        width: 300px;
        margin: 30px;
    }

    .buttonDiv {
        text-align: center;
        position: relative;
        display: inline-block;
        box-sizing: border-box;
        margin-right: auto;
        margin-left: auto;
    }

</style>