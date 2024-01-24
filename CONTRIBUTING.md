<a href="https://github.com/Dogatorix/Blahaj">
  <img width="120px" height="120px" src="https://raw.githubusercontent.com/Dogatorix/Blahaj/main/set/icon_512x.png" align="right" />
</a>

# The Guide to Contributing to the Blåhaj Repository
A guide for those who want to contribute models but struggle with GitHub.

If you still find it challenging after reading this guide, consider growing some brain cells.

## Forking
To begin, [fork the Blåhaj Repository](https://github.com/Dogatorix/Blahaj/fork). This action clones the repository to your account, allowing you to make changes. Click the fork button in the top right corner of the repository page.

## Making Changes
Now that you have your own repository, you can make changes. Edit a file by clicking the pencil icon in the top right corner. Add new files by clicking the "Add File" button on the repository page.

### Requirements for Model Acceptance:
- Place models and textures in the correct folder.
  - Plushie Model: Your `.json` file goes in `Blahaj/src/main/resources/assets/blahaj/models/block`
  - Item Model: Create a `.json` using an existing template and place it in `Blahaj/src/main/resources/assets/blahaj/models/item`
    - The item model represents how the item looks in your inventory/hand. The json's parent should match the plushie model's name.
  - Texture: Your texture (`.png`) goes in `Blahaj/src/main/resources/assets/blahaj/textures/block`

- Edit the lang file for the right in-game name and description.
  - The lang file is located at `Blahaj/src/main/resources/assets/blahaj/lang/en_us.json`
  - Key format: `block.blahaj.<model name>` and `block.blahaj.<model name>.tooltip` for the item name and description respectively.

## Committing Changes
After making changes, commit them by filling out the "Commit changes" form at the bottom of the page. While commit messages don't need to be special, providing a brief description is appreciated. Click "Commit changes" at the bottom.

## Making a Pull Request
When finished, create a pull request:
1. Go to your forked repository's main page.
2. Click "Contribute" near the top, next to "Sync Fork."
3. Click "Open Pull Request," review changes, and click "Create Pull Request" when ready.
4. Fill out the pull request form (include a detailed description of your additions) and click "Create Pull Request" again.
