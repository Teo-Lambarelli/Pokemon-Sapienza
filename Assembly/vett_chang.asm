.globl main
.data
v:.word 2,4,7,12,10,56,22,8,11,2346
lenv:.word 10
space: .asciiz " "   
.text
main:
la $t0, v
lw $t1, lenv
div $t3, $t1, 2
li $t4, 36
add $t4, $t4, $t0

li $t9,0 #lo useremo come index

jal invertib2

li $v0, 10
syscall

invertib2:
beq $t9, $t3, end
lw $t2, 0($t0)
lw $t5, 0($t4)
rem $t6, $t2, 2

beqz $t6, andd
addi $t4, $t4, -4
addi $t0, $t0, 4
addi $t9, $t9, 1
j invertib2

andd:
rem $t6, $t5, 2
beqz $t6, exch
addi $t4, $t4, -4
addi $t0, $t0, 4
addi $t9, $t9, 1
j invertib2

exch:
sw $t5, 0($t0)
sw $t2, 0($t4)
addi $t4, $t4, -4
addi $t0, $t0, 4
addi $t9, $t9, 1
j invertib2

end:
la $t0, v
xor $t9, $t9, $t9
endf:
beq $t9, $t1, ggg
lw $t8, 0($t0)

move $a0, $t8
li $v0, 1
syscall
la $a0, space
li $v0, 4        # Carica il codice della chiamata di sistema per la stampa di una stringa (syscall 4)
syscall          # Esegui la chiamata di sistema

addi $t0,$t0, 4
addi $t9,$t9, 1
j endf

ggg:
jr $ra

