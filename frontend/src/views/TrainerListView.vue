<template>
    <div class="trainerListDiv">
        <div class="card bg-primary text-white text-center p-3 titleDisplay">
            <blockquote class="blockquote mb-0">
                <p>{{username}}さんのトレーナー一覧</p>
            </blockquote>
        </div>
        <div class="card bg-success text-white text-center p-3 titleDisplay createTrainer" v-on:click="createTrainer()">
            <blockquote class="blockquote mb-0">
                <p>トレーナーの登録をする</p>
            </blockquote>
        </div>
        <div class="trainersDiv" v-for="(trainer, idx) of trainers" :key="idx">
            <div class="card text-white bg-primary mb-3" v-on:click="pushMyPokeList(trainer.id)">
                <div class="card-header">{{trainer.trainerName}}</div>
                <div class="card-body">
                    <img class="card-title" src="../assets/img/trainer_leaf.jpeg"/>
                    <p class="card-text">勝った回数：{{trainer.winningCount}}</p>
                    <p class="card-text">負けた回数：{{trainer.losingCount}}</p>
                </div>
            </div>
        </div>

        <div class="card text-white bg-danger trainersDiv pleaseCreate" v-if="trainerExist===false">
            <div class="card-header">トレーナーがまだいないようです</div>
            <div class="card-body">
                <p class="card-text">クリックでトレーナーを作成！</p>
            </div>
        </div>

    </div>
</template>

<script>
    import axios from 'axios'
    import store from '../store/index.js'
    import {mapState} from 'vuex'

    export default {
        name: "TrainerListView",
        data() {
            return {
                items: [],
                trainers: [],
                trainerExist: true,
                username: "",
            }
        },
        components: {},
        computed: {},
        watch: {
            items() {
            }
        },
        mounted() {
            axios.get("/api/trainers").then((res) => {
                this.trainers = res.data;
                if (res.data.length === 0) this.trainerExist = false;
                    console.log(res.data);
            });

            axios.get("/api/user/name").then((res) => {
                this.username = res.data;
                console.log(res.data);
            });
        },
        methods: {
            pushMyPokeList(id) {
                this.$router.push(`/myPokeList?id=${id}`);
            },
            createTrainer() {
                this.$router.push(`/trainerRegisterForm`);
            }
        }
    }
</script>

<style scoped>
    .trainersDiv {
        width: 300px;
        display: inline-block;
        margin-left: 40px;
        margin-right: 40px;
    }

    .trainersDiv:hover {
        color: red;
        cursor: pointer;
        box-shadow: 0 5px 10px 0 rgba(0, 0, 0, .5);
    }

    .mb-3 {
        margin-bottom: 0 !important;
    }

    .card-header {
        font-size: large;
        font-family: "Hiragino Kaku Gothic Pro";
    }

    .card-title {
        width: 150px;
    }

    .pleaseCreate {
        width: 400px;
    }

    .titleDisplay {
        margin-bottom: 30px;
        height: 60px;
        width: 400px;
        text-align: center;
        position: relative;
        display: block;
        margin-right: auto;
        margin-left: auto;
    }

    .createTrainer:hover {
        cursor: pointer;
        box-shadow: 0 5px 10px 0 rgba(0, 0, 0, .5);
    }

</style>