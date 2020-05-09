<template><div class = "login_form">
<el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
  <el-form-item label="Email" prop="email">
    <el-input type="email" v-model="ruleForm.email" autocomplete="off"></el-input>
  </el-form-item>
  <el-form-item label="Password" prop="pass">
    <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button id = "login-button" type="primary" @click="submitForm('ruleForm')">Log in</el-button>
  </el-form-item>
</el-form>
</div></template>
<script>
  export default {
    data() {
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('Please enter the password'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      return {
        ruleForm: {
          pass: ''
        },
        rules: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
    }
  }
</script>

<style>
.login_form{
  width:100%;
  padding-top:10%;
  clear:right;
  display: flex;
  justify-content: center;
  align-items: center;
}
#login-button{
  margin-left:30%;
}
</style>
