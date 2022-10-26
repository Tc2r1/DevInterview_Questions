# Introduction

Vim is a widely used, open-source Unix text editor. Learning to use Vim commands is a matter of practice and experience. That is why it is handy to have a helpful reference sheet while mastering them.

## Contents

- [Opening a file in vim](#how-to-open-a-file-in-vim)
- Moving
    - [By Characters, Words and Tokens](#moving-by-characters-words-and-tokens)
    - [By Lines](#moving-by-lines)
    - [By Screens](#moving-by-Screens)
- [Inserting Text](#inserting-text)
- [Editing Text](#editing-text)
- [Cutting, Copying And Pasting](#cutting-copying-and-pasting)
- [Marking Text (Visual Mode)](#marking-text-visual-mode)
- [Visual Commands](#visual-commands)
- [Search in File](sSearch-in-file)
- [Saving and Exiting File](#saving-and-exiting-file)
- [Enabling Vim Color Schemes](#enabling-vim-color-Schemes)


## How to open a file in vim
```vim
$ vim <file path>
```
Example:
```vim
$ vim './myRepo/README.md'
or
$ vim README.md 
```

## Moving by Characters, Words and Tokens

The basic keys for moving the cursor by one character are:
- `h` – move the cursor left 
- `j` – move the cursor down 
- `k` – move the cursor up 
- `l` – move the cursor right

You can also use these keys with a number as a prefix to move in a specified direction multiple times. For example, if you run 5j the cursor moves down 5 lines.

- `b` – move to the start of a word
- `B` – move to the start of a token
- `w` – move to the start of the next word
- `W` – move to the start of the next token
- `e` – move to the end of a word
- `E` – move to the end of a token

## Moving by Lines
- `0` (zero) – jump to the beginning of the line
- `$` – jump to the end of the line
- `^` – jump to the first (non-blank) character of the line
- `#G` / `#gg` / `:#` – move to a specified line number (replace # with the line number)

## Moving by Screens

- `Ctrl + b` – move back one full screen
- `Ctrl + f`– move forward one full screen
- `Ctrl + d` – move forward 1/2 a screen
- `Ctrl + u` – move back 1/2 a screen
- `Ctrl + e` – move screen down one line (without moving the cursor)
- `Ctrl + y` – move screen up one line (without moving the cursor)
- `Ctrl + o` – move backward through the jump history
- `Ctrl + i` – move forward through the jump history

<br/>

- `H` – move to the top of the screen (H=high)
- `M` – move to the middle of the screen (M=middle)
- `L` – move to the bottom of the screen (L=low)

## Inserting Text
 - `i` – switch to insert mode before the cursor
 - `I` – insert text at the beginning of the line
 - `a` – switch to insert mode after the cursor
 - `A` – insert text at the end of the line
 - `o` – open a new line below the current one
 - `O` – open a new line above the current one
 - `ea` – insert text at the end of the word
 - `Esc` – exit insert mode; switch to command mode

Some of these commands switch between command and insert mode. By default, Vim launches in command mode, allowing you to move around and edit the file. To switch to command mode, use the Esc key.

On the other hand, the insert mode enables you to type and add text into the file. To move to insert mode, press i.

## Editing Text

- `r` – replace a single character (and return to command mode)
- `cc` – replace an entire line (deletes the line and moves into insert mode)
- `C` / `c$` – replace from the cursor to the end of a line
- `cw` – replace from the cursor to the end of a word
- `s` – delete a character (and move into insert mode)
- `J` – merge the line below to the current one with a space in between them
- `gJ` – merge the line below to the current one with no space in between them
- `u` – undo
- `Ctrl + r` – redo
- `.` – repeat last command

## Cutting, Copying And Pasting

- `yy` – copy (yank) entire line
- `#yy` – copy the specified number of lines
- `dd` – cut (delete) entire line
- `#dd` – cut the specified number of lines
- `p` – paste after the cursor
- `P` – paste before the cursor
  
  Replace # by number

## Marking Text (Visual Mode)
Apart from command mode and insert mode, Vim also includes visual mode. This mode is mainly used for marking text.

Based on the chunk of text you want to select, you can choose between three versions of visual mode: character mode, line mode, and block mode.

- `v` – select text using character mode
- `V` – select lines using line mode
- `Ctrl+v` – select text using block mode

Once you have enabled one of the modes, use the navigation keys to select the desired text.

- `o` – move from one end of the selected text to the other
- `aw` – select a word
- `ab` – select a block with ()
- `aB` – select a block with {}
- `at` – select a block with <>
- `ib` – select inner block with ()
- `iB` – select inner block with {}
- `it` – select inner block with <>

## Visual Commands
Once you have selected the desired text in visual mode, you can use one of the visual commands to manipulate it. Some of them include:
 - `y` – yank (copy) the marked text
 - `d` – delete (cut) the marked text
 - `p` – paste the text after the cursor
 - `u` – change the market text to lowercase
 - `U` – change the market text to uppercase

## Search in File

 - `*` – jump to the next instance of the current word
 - `#` – jump to previous instance of the current word
 - `/pattern` – search forward for the specified pattern
 - `?pattern` – search backward for the specified pattern
 - `n` – repeat the search in the same direction
 - `N` – repeat the search in the opposite direction

## Saving and Exiting File
 - `:w` – save the file
 - `:wq` / `:x` / `ZZ` – save and close the file
 - `:q` – quit
 - `:q!`/ `ZQ` – quit without saving changes
 - `:w` new_file_name – save the file under a new name and continue editing the original
 - `:sav` – save the file under a new name and continue editing the new copy
 - `:w !sudo tee %` – write out the file using sudo and tee command

## Enabling Vim Color Schemes
- `:colorscheme [colorscheme_name]`  – change to specified scheme
- `:colorscheme [space]+Ctrl+d` – list available Vim color scheme
