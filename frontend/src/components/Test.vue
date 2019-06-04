<template>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(customer, index) in customers" :key="index">
                <td>{{customer.id}}</td>
                <td>{{customer.firstName}}</td>
                <td>{{customer.lastName}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import axios from 'axios';
    export default {
        data() {
            return {
                customers: []
            }
        },
        created() {
            axios.get(`/backend/customer/list`)
                .then(response => {
                    this.customers = response.data;
                });
        }
    }
</script>
<style scoped>
</style>