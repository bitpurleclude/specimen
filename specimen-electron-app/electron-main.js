import { app, BrowserWindow } from 'electron';
import path from 'path';
import url from 'url';


function createWindow() {
    const win = new BrowserWindow({
        width: 800,
        height: 600,
        webPreferences: {
            nodeIntegration: true,
            contextIsolation: false,
        },
    });

    // 加载 Vue 应用。如果是开发模式，加载 Vite 服务器的地址；如果是生产模式，加载构建后的 index.html。
    const startUrl =
        process.env.NODE_ENV === 'development'
            ? 'http://localhost:3000' // Vite 默认端口
            : url.format({
                pathname: path.join(__dirname, 'dist/index.html'),
                protocol: 'file:',
                slashes: true,
            });
    win.loadURL(startUrl);
}

app.whenReady().then(createWindow);

app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
        app.quit();
    }
});