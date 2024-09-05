const { defineConfig } = require('@vue/cli-service')
const path = require('path')
function resolve(dir) {
  return path.join(__dirname, dir)
}
module.exports = defineConfig({
  publicPath: '',
  // 输出文件目录
  outputDir: 'xzy-admin',
  transpileDependencies: true,
  productionSourceMap: false,
  devServer: {
    port:9991,
    proxy: {
      '/api': {
        target: 'http://localhost:9990/api',
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    },
    historyApiFallback: true, //外网访问必须加
    allowedHosts: 'all' //允许访问,指定后端接口，比如*.*.com
  },
  chainWebpack: (config) => {
    config.resolve.alias.set('@', resolve('src'))
  }
})
