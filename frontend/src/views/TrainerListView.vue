<template>
<div class="trainerListDiv">
            <div class="trainersDiv" v-for="(trainer, idx) of trainers" :key="idx">
                <div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
                    <div class="card-header">{{trainer.trainerName}}</div>
                    <div class="card-body">
                        <img class="card-title" src="../assets/img/trainer_leaf.jpeg" />
                        <p class="card-text">勝った回数：{{trainer.winningCount}}</p>
                        <p class="card-text">負けた回数：{{trainer.losingCount}}</p>
                    </div>
                </div>
            </div>
</div>
</template>

<script>
    import axios from 'axios'
    import store from '../store/index.js'
    import { mapState } from 'vuex'

    export default {
        name: "TrainerListView",
        data() {
            return {
                items: [],
                trainers: [],
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
                console.log(res.data);
            })
        },
        methods: {
        }
    }
</script>

<style scoped>
    .trainersDiv {
        display: inline-block;
        margin-left: 40px;
        margin-right: 40px;
    }

    .trainersDiv:hover {
        color: red;
        cursor: pointer;
        box-shadow: 0 5px 10px 0 rgba(0,0,0,.5);
    }
    .mb-3 {
        margin-bottom: 0 !important;
    }

    .card-header {
        font-size: x-large;
        font-family: "Hiragino Kaku Gothic Pro";
    }

    .card-title {
        width: 150px;
    }

</style>