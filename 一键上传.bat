@echo off
chcp 65001 >nul
setlocal
cd /d "%~dp0"
title 一键上传到 GitHub

rem ===== 确保能找到 git =====
where git >nul 2>&1
if errorlevel 1 if exist "C:\Program Files\Git\cmd\git.exe" set "PATH=C:\Program Files\Git\cmd;%PATH%"
where git >nul 2>&1
if errorlevel 1 (
    echo.
    echo [错误] 没有找到 git 命令，请先安装 Git for Windows。
    echo.
    pause
    exit /b 1
)

echo.
echo ==========================================
echo            一键上传到 GitHub
echo ==========================================
echo.

git rev-parse --is-inside-work-tree >nul 2>&1
if errorlevel 1 (
    echo [错误] 当前目录不是 Git 仓库：%CD%
    echo.
    pause
    exit /b 1
)

rem ===== 第一次使用时关联远程仓库 =====
set "REMOTE_URL="
for /f "delims=" %%i in ('git remote get-url origin 2^>nul') do set "REMOTE_URL=%%i"

if not defined REMOTE_URL (
    echo [首次使用] 这个项目还没有关联 GitHub 仓库。
    echo 请先在 GitHub 网页上新建一个空仓库（不要勾 README），
    echo 然后复制它的 HTTPS 地址，形如：
    echo     https://github.com/用户名/KT.git
    echo.
    set /p "REMOTE_URL=把地址粘到这里再按回车： "
    if not defined REMOTE_URL (
        echo.
        echo [已取消] 没有输入地址。
        pause
        exit /b 1
    )
    git remote add origin "%REMOTE_URL%"
    if errorlevel 1 (
        echo [错误] 关联远程仓库失败。
        pause
        exit /b 1
    )
    echo [完成] 已关联：%REMOTE_URL%
    echo.
)

rem ===== 本次修改说明 =====
set "MSG=%~1"
if not defined MSG set /p "MSG=输入本次修改说明（直接回车 = update）： "
if not defined MSG set "MSG=update"

echo.
echo [1/3] 收集改动...
git add -A

echo [2/3] 生成提交...
git diff --cached --quiet
if errorlevel 1 (
    git commit -m "%MSG%"
) else (
    echo       没有新改动，跳过提交。
)

echo [3/3] 推送到 GitHub...
git push -u origin HEAD
if errorlevel 1 (
    echo.
    echo [提示] 推送失败，常见原因：
    echo    1. 代理 127.0.0.1:7890 没开
    echo    2. GitHub 那个仓库不是空的（建仓库时勾了 README）
    echo       解决：先执行  git pull --rebase origin main  再重跑本脚本
    echo    3. 没登录 GitHub，或没有该仓库的权限
    echo.
) else (
    echo.
    echo [成功] 已经上传到 GitHub。
)

echo.
pause
endlocal
