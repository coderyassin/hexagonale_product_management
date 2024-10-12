module.exports = {
    mongodb: {
        server: 'mongo',
        port: 27017,
        adminUsername: process.env.MONGO_ADMIN_USERNAME,
        adminPassword: process.env.MONGO_ADMIN_PASSWORD,
    },
    site: {
        port: 8081,
    },
};
