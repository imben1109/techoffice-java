const path = require('path');

module.exports = {
	entry: './src/App.ts',
	output: {
		path: path.resolve(__dirname, 'bin'),
		filename: 'app.bundle.js'
	},
	devtool: "eval-source-map",
	module: {
		loaders: [
			{
				test: /\.ts$/,
				loaders: ['babel-loader', 'ts-loader'],
				exclude: [
					/node_modules/
				]
			}
		]
	},
	resolve: {
		extensions: ['.js', '.ts'], 
		modules: [ path.resolve(__dirname, 'src'), 'node_modules' ] 
    }
}; 