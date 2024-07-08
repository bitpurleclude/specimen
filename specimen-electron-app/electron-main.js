import { app, BrowserWindow } from 'electron';
import path from 'path';
import { fileURLToPath, URL } from 'url'; // 导入 URL 模块

function createWindow() {
    const win = new BrowserWindow({
        width: 800,
        height: 600,
        webPreferences: {
            nodeIntegration: true,
            contextIsolation: false,
        },
    });

    const __dirname = path.dirname(fileURLToPath(import.meta.url));

    const startUrl =
        process.env.NODE_ENV === 'development'
            ? 'http://localhost:5173' // Vite 默认端口
            : new URL('dist/index.html', `file://${__dirname}/`).toString(); // 使用 URL 构造函数代替 url.format
    win.loadURL(startUrl);
}

app.whenReady().then(createWindow);

app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
        app.quit();
    }
});