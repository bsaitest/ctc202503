export default {
    testEnvironment: "jsdom",
    transform: {
        "^.+\.vue$": "@vue/vue3-jest",
        "^.+\(js|jsx|ts|tsx)$": "babel-jest",
    },
    testRegex: "(/__tests__/.*|(\.|/)(test|spec))\.(js|ts)$",
    moduleFileExtensions: ["vue", "js", "ts", "json"],
    moduleNameMapper: {
        "^@/(.*)$": "<rootDir>/src/$1",
    },
    coveragePathIgnorePatterns: ["/node_modules/", "/tests/"],
    coverageReporters: ["text", "json-summary"],
    // Fix in order for vue-test-utils to work with Jest 29
    // https://test-utils.vuejs.org/migration/#test-runners-upgrade-notes
    testEnvironmentOptions: {
        customExportConditions: ["node", "node-addons"],
    },
}