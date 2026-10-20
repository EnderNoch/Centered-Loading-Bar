# Centered Loading Bar

[Modrinth](https://modrinth.com/project/clb) · A small client-side Fabric mod for Minecraft 26.3. It hides the Mojang Studios logo on loading screens and moves the loading bar to the middle of the screen.

![Vanilla loading screen next to Centered Loading Bar](screenshots/comparison.png)

Works on its own and alongside [Reimagined Intro](https://modrinth.com/mod/reimagined-intro). Needs only Fabric Loader; Fabric API is not required.

## Building

Requires a JDK 17+ to start Gradle; Gradle downloads JDK 25 for the build by itself.

```
./gradlew build
```

The mod jar ends up in `build/libs/`.

## Publishing to Modrinth

Bump `version` in `gradle.properties`, then:

```
CHANGELOG="..." ./gradlew build modrinth
```

The token is read from `MODRINTH_TOKEN`, or else from `~/.config/modrinth/token`; it needs the Create versions, Read versions and Write versions scopes. After the upload the version is marked client-only automatically. Add `-PmodrinthDebug` to see what would be uploaded without uploading it.

## License

MIT. Not an official Minecraft product. Not approved by or associated with Mojang or Microsoft.
