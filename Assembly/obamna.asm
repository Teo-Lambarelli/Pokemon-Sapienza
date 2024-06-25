.data

IMP:.asciiz "IMPOSSIBILE"

.text
la $t9, IMP
li $v0, 5
syscall
move $t0, $v0 #mettiamo n in t0
beqz $v0, error #se il numero dato è 0 stampa "ERROR"
li $t6, 1

inizio:
li $t7, 0
li $t1, 2
loop:

mul $t1, $t1, 2
addi $t7, $t7, 1
beq $t7 $t6, endpow
j loop

endpow:
bgt $t1, $t0 end2
beq $t1, $t0 end
addi $t6, $t6, 1
j inizio

end:
addi $t6, $t6, 1
move $a0, $t6
li $v0, 1
syscall
li $v0, 10
syscall

end2:
move $a0, $t6
li $v0, 1
syscall
li $v0, 10
syscall

error:
move $a0, $t9
li $v0, 4
syscall
li $v0, 10
syscall