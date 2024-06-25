#Definire una matrice 5x5 di halfword. Realizzare un programma in linguaggio assemblativo che consente ad un utente di inserire da tastiera il
#numero di riga ed il numero di colonna e visualizzare su schermo l'elemento.

.globl main
.data
matrix:.half 1,0,4,4,5 2,9,4,1,9 ,8,5,6,3,6, 1,5,7,2,5, 2,4,5,7,2
.text
main:
la $t5, matrix
li $t2, 5

li $v0, 5 #riga
syscall
move $t0, $v0

li $v0, 5 #colonna
syscall
move $t1, $v0

mul $t3, $t0, $t2 #righa per colonnetotali

mul $t3, $t3, 2 

mul $t1, $t1, 2

add $t3, $t3, $t1

add $t3, $t3, $t5

lh $t5, 0($t3)

move $a0, $t5

li $v0, 1
syscall

li $v0, 10
syscall



