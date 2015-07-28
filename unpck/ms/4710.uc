class 4710 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect0
		AttachOn=AM_RA
		AttachBoneName="soulshot1"
		bAbsolute=True
		EffectClass=Class'LineageEffect.at_stun_attack_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect1
		AttachOn=AM_RA
		AttachBoneName="soulshot1"
		bAbsolute=True
		EffectClass=Class'LineageEffect.at_shield_stun_cs'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect2
		AttachOn=AM_LA
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_stun_attack_ta'
	End Object
	Desc="소환수 와일드 스턴" //Wild pet Stern
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect0',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect1',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect2',SpecificStage=0)
}