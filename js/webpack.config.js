const path = require('path');
const HTMLWebpackPlugin = require('html-webpack-plugin');
const { config } = require('process');

module.exports = {

    entry: './src/index.js',

    output: {
        path: path.join(__dirname, '/dist'),
        filename: 'bundle.js'
    },
    devServer: {
        static: path.resolve(__dirname, 'dist'),
        port: 3000,
        hot: true
      },

    plugins: [
        new HTMLWebpackPlugin({
            template: './dist/index.html'
        })
    ],
    resolve:{
        extensions : ['.js', '.jsx']
    },

    module: {
        rules: [
            {
                test: /\.(scss)$/,
                use:[
                    {
                        loader: 'style-loader'
                    },
                    {
                        loader: 'css-loader'
                    },
                      {
                        loader: 'postcss-loader',
                        options: {
                          postcssOptions: {
                            plugins: () => [
                              require('autoprefixer')
                            ]
                          }
                        }
                    },
                    {
                        loader: 'sass-loader'
                      }

                ]
              
              },
            {
                test: /\.(jsx|js)$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env', '@babel/preset-react']
                        }
                }
            }
            
        ]
    }
}