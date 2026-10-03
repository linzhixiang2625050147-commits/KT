# KT — Kotlin 练习项目

一个用 Kotlin 写的命令行「任务管理」练习程序。

## 目录说明

| 路径 | 说明 |
| --- | --- |
| `KTProject/` | Gradle 项目本体，源码在 `KTProject/src/main/kotlin/index.kt` |
| `android-sdk/`、`jdk-21/`、`kotlinc/`、`gradle/` | 本地工具链，体积大且不允许再分发，**不会被上传到 GitHub**（见 `.gitignore`） |

## 怎么上传到 GitHub

### 方法一：双击 `一键上传.bat`（最省事）

双击本目录下的 `一键上传.bat`，按提示操作即可：

- **第一次运行**：它会让你粘贴 GitHub 仓库地址，粘贴一次就记住了，以后不用再管。
- **以后每次**：双击 → 输入一句修改说明（直接回车就填 `update`）→ 自动提交并上传。

### 方法二：用 IntelliJ IDEA 的按钮

你在用的 IntelliJ IDEA 自带 Git 图形界面，不需要记任何命令：

1. 菜单 `Git` → `Commit`（快捷键 `Ctrl+K`）
2. 左边勾选要提交的文件，下面填一句说明，点 `Commit`
3. 再点工具栏右上角的 `Push`（快捷键 `Ctrl+Shift+K`），或菜单 `Git` → `Push`

### 方法三：命令行（就三句）

```bat
cd /d E:\codex\KT
git add -A
git commit -m "这次改了什么"
git push
```

## 常用命令速查

| 想干什么 | 命令 |
| --- | --- |
| 看现在有哪些改动 | `git status` |
| 看改动内容 | `git diff` |
| 看提交历史 | `git log --oneline` |
| 把改动全部暂存 | `git add -A` |
| 提交 | `git commit -m "说明"` |
| 上传 | `git push` |
| 从 GitHub 拉取别人的改动 | `git pull` |

## 遇到问题

**`git` 不是内部或外部命令**
说明当前窗口是在装 Git 之前打开的，关掉重新开一个 cmd 窗口即可。

**推送失败，提示代理相关错误**
你给 Git 配了代理 `http://127.0.0.1:7890`，推送时这个代理软件必须开着。
不想走代理可以执行：`git config --global --unset http.proxy` 和 `git config --global --unset https.proxy`

**推送被拒绝（rejected / fetch first）**
说明 GitHub 上的仓库不是空的（建仓库时勾了 README）。执行一次
`git pull --rebase origin main` 再 `git push` 即可。

**不小心把不该上传的文件加进来了**
在 `.gitignore` 里加一行文件名或目录名（如 `/index.jar`），然后执行
`git rm -r --cached 文件名` 再提交。
