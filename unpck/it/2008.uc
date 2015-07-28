class 2008 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect8
		AttachOn=AM_RA
		AttachBoneName="soulshot1"
		bAbsolute=True
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.it_spirit_shot_d_ca'
	End Object
	Desc="소환수마정탄" //Pet Spiritshot
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect8',SpecificStage=0)
}