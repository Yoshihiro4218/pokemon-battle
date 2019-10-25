<template>
  <div class="registerDiv">
    <h2>UserRegister!!</h2>

    <div class="cotainer">
      <div class="row justify-content-center">
        <div class="col-md-8">
          <div class="card">
            <div class="card-header">Register</div>
            <div class="card-body">
              <form name="my-form" onsubmit="return validform()" action="success.php" method="">
                <div class="form-group row">
                  <label for="full_name" class="col-md-4 col-form-label text-md-right">Full
                    Name</label>
                  <div class="col-md-6">
                    <input type="text" id="full_name" class="form-control" name="full-name">
                  </div>
                </div>

                <div class="form-group row">
                  <label for="email_address" class="col-md-4 col-form-label text-md-right">E-Mail
                    Address</label>
                  <div class="col-md-6">
                    <input type="text" id="email_address" class="form-control" name="email-address">
                  </div>
                </div>

                <div class="form-group row">
                  <label for="user_name" class="col-md-4 col-form-label text-md-right">User
                    Name</label>
                  <div class="col-md-6">
                    <input type="text" id="user_name" class="form-control" name="username">
                  </div>
                </div>

                <div class="form-group row">
                  <label for="phone_number" class="col-md-4 col-form-label text-md-right">Phone
                    Number</label>
                  <div class="col-md-6">
                    <input type="text" id="phone_number" class="form-control">
                  </div>
                </div>

                <div class="form-group row">
                  <label for="present_address" class="col-md-4 col-form-label text-md-right">Present
                    Address</label>
                  <div class="col-md-6">
                    <input type="text" id="present_address" class="form-control">
                  </div>
                </div>

                <div class="form-group row">
                  <label for="permanent_address" class="col-md-4 col-form-label text-md-right">Permanent
                    Address</label>
                  <div class="col-md-6">
                    <input type="text" id="permanent_address" class="form-control"
                           name="permanent-address">
                  </div>
                </div>

                <div class="form-group row">
                  <label for="nid_number" class="col-md-4 col-form-label text-md-right"><abbr
                      title="National Id Card">NID</abbr> Number</label>
                  <div class="col-md-6">
                    <input type="text" id="nid_number" class="form-control" name="nid-number">
                  </div>
                </div>

                <div class="col-md-6 offset-md-4">
                  <button type="submit" class="btn btn-primary">
                    Register
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
  import axios from 'axios'
  import store from '../store/index.js'
  import {mapState} from 'vuex'

  export default {
    name: "Login",
    data() {
      return {
        items: [],
        csrf: "",
      }
    },
    components: {},
    computed: {},
    watch: {
      items() {
      }
    },
    mounted() {
      axios.get("/api/prelogin")
      .then((res) => {
        console.log(res.data);
        this.csrf = res.data;
      })
    },
    methods: {
      login() {
        let params = new URLSearchParams();
        params.append('email', document.getElementById("email").value);
        params.append('pass', document.getElementById("password").value);
        params.append('_csrf', this.csrf);
        console.log(document.getElementById("email").value);
        console.log(this.csrf);
        console.log(params);
        axios.post("/api/login", params).then((res) => {
          console.log(res)
          this.$router.push("/trainerList")

        });
      }
    }
  }
</script>

<style scoped>
    @import url(https://fonts.googleapis.com/css?family=Raleway:300,400,600);

    .registerDiv {
    text-align: center;
    position: relative;
    display: block;
    box-sizing: border-box;
    margin-right: auto;
    margin-left: auto;
  }

  form {
    text-align: center;
  }

  .form-group {
    margin-right: auto;
    margin-left: auto;
    width: 500px;
    text-align: center;
  }

    body {
    margin: 0;
    font-size: .9rem;
    font-weight: 400;
    line-height: 1.6;
    color: #212529;
    text-align: left;
    background-color: #f5f8fa;
  }

  .navbar-laravel {
    box-shadow: 0 2px 4px rgba(0, 0, 0, .04);
  }

  .navbar-brand, .nav-link, .my-form, .login-form {
    font-family: Raleway, sans-serif;
  }

  .my-form {
    padding-top: 1.5rem;
    padding-bottom: 1.5rem;
  }

  .my-form .row {
    margin-left: 0;
    margin-right: 0;
  }

  .login-form {
    padding-top: 1.5rem;
    padding-bottom: 1.5rem;
  }

  .login-form .row {
    margin-left: 0;
    margin-right: 0;
  }

</style>