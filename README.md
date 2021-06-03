# MinesocialSupport
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
3. Зарегистрироваться на сайте Minesocial.net и подтвердить свою почту.
4. Войти под своими email и password в лаунчер 

