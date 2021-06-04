# MineSocialSupport
Добавляет [GravitLauncher] поддержку **Minesocial.net**
#### Установка модуля
1. Скопировать модуль **MinesocialSupport_module.jar** в папку **/LaunchServer/modules/**
2. Выполнить настройку `auth provider`, `auth handler` и `auth textureProvider`

```json
{
  "provider": {
    "type": "minesocial"
  },
  "handler": {
    "type": "minesocial"
  },
  "textureProvider": {
    "type": "minesocial"
  }
}
```
# Модуль MineSocial использует переделаную авторизацию mojang по этому для его работы не нужен ServerWrapper
# Клиент настраиваем по инструкции вашей версии

#### Установка сервера

1. Скачиваем патченое ядро с нашего зеркала --> https://files.minesocial.net/servers/

2. Включаем online mode = true

Готово! Теперь вам осталось только зарегистрироваться на сайте и войти в свой аккаунт в лаунчере.

Примечание: В колонке логин используем вашу почту!


